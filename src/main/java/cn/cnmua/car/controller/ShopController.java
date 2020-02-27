package cn.cnmua.car.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.domian.Shop;
import cn.cnmua.car.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author hjf
 * @Date 2019/12/5
 * 4s店信息相关操作
 **/
@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    //获取店铺全部信息
    @RequestMapping("getAllShop")
    public List getAllShop(@RequestParam(value = "id" ,defaultValue = "") String id){
        QueryWrapper queryWrapper=new QueryWrapper();
        if (!"".equals(id)){
            queryWrapper.eq("id",id);
        }
        List<Shop> list = shopService.getAll(queryWrapper);
        return list;
    }
    //添加新的店铺
    @RequestMapping("saveShopImg")
    public Msg saveShopImg(Integer id,MultipartFile shopImg ){
        System.out.println("进入新建4s店铺方法");
        //上传图片
        String name = shopImg.getOriginalFilename();
        String str[] = name.split("\\.");
        //uuid生成文件夹
        String uuid = UUID.randomUUID().toString();
        //uuid生成新的文件名,既要保存的路径
        String newFileName = UUID.randomUUID().toString().replace("-", "").substring(0, 10)+"."+str[str.length-1];
        //拼接到项目或者定义好的目录下
        String path = uuid.replace("-", "").substring(0, 5);
        //保存到该目录
        String path0="d:\\test";
        File savePath = new File(path0 +"\\"+ path);
        //判断文件夹是否存在，不存在则创建
        if (!savePath.exists()){
            savePath.mkdir();
        }

        try {
            File file = new File(savePath, newFileName);
            shopImg.transferTo(file);
            System.out.println("图片上传成功："+savePath+"\\"+newFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.success().add("msg","图片上传失败，其他操作已终止！");
        }



//        Shop shopInfo = new Shop(shopName,shopAddress,shopPhone,path0 +"\\"+ path+"\\"+newFileName,shopState,message);
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Shop shop = shopService.findShopByCondition(queryWrapper);

        //用于存储到数据库的访问路径
        String realPath = "ourPath\\"+path+"\\"+newFileName;
        shop.setShopImg(realPath);
        int i = shopService.updateShop(shop);
        if (i>0) {
            return Msg.success().add("msg","添加图片成功");
        }else {
            return Msg.success().add("msg","添加图片成功");
        }
    }

    @RequestMapping("saveShop")
    public Msg saveShop(@RequestParam(value ="shopName") String shopName,@RequestParam(value ="provinces") String provinces,@RequestParam(value ="city") String city,
                            @RequestParam(value ="district") String district,@RequestParam(value ="shopAddress") String shopAddress,
                            @RequestParam(value ="shopPhone") String shopPhone,@RequestParam(value ="shopDesc") String shopDesc,
                            @RequestParam(value = "shopState",defaultValue = "无") String shopState,@RequestParam(value = "message",defaultValue = "") String message){
        System.out.println("进入新建4s店铺方法");



        Shop shopInfo = new Shop(0,shopName,provinces,city,district,shopAddress,shopPhone,null,shopDesc,null,null);
        System.out.println(shopInfo.toString());
        int i = shopService.saveShop(shopInfo);
        if (i>0) {
            return Msg.success().add("msg","新建店铺成功");
        }else {
            return Msg.success().add("msg","新建店铺失败");
        }
    }
    //删除店铺
    @RequestMapping("deleteShop")
    public Msg deleteShopInfo(String id){
        String []ids = id.split(",");
        System.out.println(ids.length);
        int success=0;
        int fail=0;
        //多行删除
        if (ids.length>1){
            for (int k = 0;k < ids.length;k++){
                System.out.println("循环"+k);
                //通过id获取此条店铺记录
                QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
                queryWrapper
                        .eq("id",ids[k]);
                Shop info = shopService.findShopByCondition(queryWrapper);
                //删除店铺前先删除图片
                File file = null;
                try {
                    file = new File(info.getShopImg());
                    file.delete();

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                int i = shopService.deleteShop(ids[k]);
                if (i>0){
                    success++;
                }else {
                    fail++;
                }
                return Msg.success().add("msg","共执行："+ids.length+"条，成功："+success+"条，失败："+fail+"条");
            }

        }


        //通过id获取此条店铺记录
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("id",ids[0]);
        Shop info = shopService.findShopByCondition(queryWrapper);
        //删除店铺前先删除图片
        File file = null;
        try {
            file = new File(info.getShopImg());
            file.delete();

        } catch (Exception e) {
            shopService.deleteShop(ids[0]);
            return Msg.success().add("msg","删除成功，图片文件已丢失！");
        }
        shopService.deleteShop(ids[0]);
        return Msg.success().add("msg",info.getShopName()+"~删除成功！");

    }

    //得到店铺信息，并且分页。出口开传入分页参数外，还可以传入两个辅助参数{shopName，address}
    @RequestMapping("getShop")
    public Page getShopInfo(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "limit",defaultValue = "10") int limit
            ,@RequestParam(value = "shopName",defaultValue = "") String shopName,@RequestParam(value = "shopAddress",defaultValue = "") String shopAddress){
        boolean flag = false;
        Page<Shop> shopInfoPage = new Page<>(page,limit);
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        if (shopName.isEmpty() == flag && shopAddress.isEmpty()== flag){
            queryWrapper
                    .like("shop_name",shopName)
                    .like("shop_address",shopAddress);
        }else if (shopName.isEmpty() != flag && shopAddress.isEmpty()== flag){
            queryWrapper
                    .like("shop_address",shopAddress);
        }else if (shopName.isEmpty() == flag && shopAddress.isEmpty() != flag){
            queryWrapper
                    .like("shop_name",shopName);
        }else {
            System.out.println("do nothing");
        }
        Page<Shop> info = shopService.findShopByConditionWithPage(shopInfoPage, queryWrapper);
        return info;
    }
    //修改店铺信息，状态和回执消息
    @RequestMapping("updateShop")
    public Msg updateShop(String id,MultipartFile shopImg){
        return Msg.success();

    }
}
