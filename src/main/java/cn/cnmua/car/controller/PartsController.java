package cn.cnmua.car.controller;

import cn.cnmua.car.domian.*;
import cn.cnmua.car.service.PartsImgService;
import cn.cnmua.car.service.PartsService;
import cn.cnmua.car.service.PartsTypeService;
import com.alibaba.druid.sql.visitor.functions.If;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * @Date 2019/12/31
 * 配件相关接口，此处未完成。。。
 **/
@RestController
public class PartsController {
    @Autowired
    private PartsService partsService;
    @Autowired
    private PartsTypeService partsTypeService;
    @Autowired
    private PartsImgService partsImgService;


    //根据条件查询一个parts
    //获取配件商场全部数据
    @RequestMapping("selectPartsAll")
    public Msg selectPartsAll(){
        List list = partsService.selectPartsAll();
        return Msg.success().add("records",list).add("total",list.size());
    }
    //添加新的店铺
    @RequestMapping("savePartsImg")
    public Msg savePartsImg(Integer id,MultipartFile img ){
        System.out.println("进入配件图片添加方法");
        //上传图片
        String name = img.getOriginalFilename();
        System.out.println(id+name+"lalala");
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
            img.transferTo(file);
            System.out.println("图片上传成功："+savePath+"\\"+newFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.success().add("msg","图片上传失败，其他操作已终止！");
        }



//        Shop shopInfo = new Shop(shopName,shopAddress,shopPhone,path0 +"\\"+ path+"\\"+newFileName,shopState,message);
        QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Parts parts = partsService.findPartsByCondition(queryWrapper);

        //用于存储到数据库的访问路径
        String realPath = "ourPath\\"+path+"\\"+newFileName;
        parts.setPartsImg(realPath);
        int i = partsService.updatePartsById(parts);
        if (i>0) {
            return Msg.success().add("msg","添加配件图片成功");
        }else {
            return Msg.success().add("msg","添加配件图片成失败");
        }
    }
    @RequestMapping("saveParts")
    public Msg saveParts(@RequestParam(value = "typeId") String partsTypeId ,@RequestParam(value = "produce") String produce,
                         @RequestParam("partsName") String partsName,@RequestParam(value = "partsPrice") String partsPrice,
                         @RequestParam(value = "partsDesc") String partsDesc,@RequestParam(value = "discount" ,defaultValue = "1") String discount){

        Parts parts = new Parts(0,partsTypeId,produce,partsName,partsPrice,partsDesc,"null",discount);

        int i = partsService.saveParts(parts);
        if (i>0){
            return Msg.success().add("msg","新增配件数据成功");
        }else {
            return Msg.success().add("msg","新增配件数据失败");
        }
    }

    //删除数据
    @RequestMapping("deleteParts")
    public Msg deleteParts(String id){
        //判断是多个删除还是单个删除
        int success=0;
        int fail=0;
        String ids[]=id.split(",");
        System.out.println(ids.length);
        if (ids.length>1){
            for (int k=0;k<ids.length;k++){
                int i = partsService.deletePartsById(ids[k]);
                if (i>0){
                    success++;
                }else {
                    fail++;
                }
            }
            return Msg.success().add("msg","共执行"+ids.length+"条，成功:"+success+"条，失败:"+fail+"条");
        }
        //一个记录删除执行下面的操作
        int i = partsService.deletePartsById(id);
        if (i>0){
            /*

            此处同时也要删除和配件图片相关的信息

             */
            return Msg.success().add("msg","删除配件信息成功");
        }else {
            return Msg.success().add("msg","删除配件信息失败");
        }
    }
    //修改数据
    @RequestMapping("updateParts")
    public Msg updateParts(@RequestParam(value = "id") String id,@RequestParam(value = "typeId") String partsTypeId ,@RequestParam(value = "produce") String produce,
                           @RequestParam("partsName") String partsName,@RequestParam(value = "partsPrice") String partsPrice,
                           @RequestParam(value = "partsDesc") String partsDesc,@RequestParam(value = "discount" ,defaultValue = "1") String discount){
        Parts one = partsService.selectOneById(id);
        //先查询是否存在此数据，不存在的话，返回
        try {
            one.getPartsName().isEmpty();
        }catch (NullPointerException e){
            return Msg.success().add("msg","此数据已失效");
        }
        one.setId(Integer.valueOf(id));
        one.setDiscount(discount);
        one.setPartsDesc(partsDesc);
        one.setPartsName(partsName);
        one.setPartsPrice(partsPrice);
        one.setPartsTypeId(partsTypeId);
        one.setProduce(produce);

        int i = partsService.updatePartsById(one);
        if (i>0){
            return Msg.success().add("msg","更新配件数据成功");
        }else {
            return Msg.success().add("msg","更新配件数据失败");
        }
    }
    //查询数据，带上分页和条件查询
    @RequestMapping("getPartsWithPageAndCondition")
    public Page getPartsWithPageAndCondition(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                             @RequestParam(value = "partsName", defaultValue = "") String partsName){
        Page<Parts> pageInfo = new Page<>(page,limit);
        QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
        if (!partsName.isEmpty()) {
            queryWrapper.eq("parts_name", partsName);
        }
        Page<Parts> info = partsService.selectPartsByCondition(pageInfo, queryWrapper);
        return info;
    }

    /**
     *此处关于配件类型的操作
     *增删改查
     */
    //增加配件类型
    @RequestMapping("savePartsType")
    public Msg savePartsType(String name){
        PartsType partsType = new PartsType(0,name);
        int i = partsTypeService.savePartsType(partsType);
        if (i>0){
            return Msg.success().add("msg","新增配件类型成功");
        }else {
            return Msg.success().add("msg","新增配件类型失败");
        }
    }
    //删除配件类型
    @RequestMapping("deletePartsType")
    public Msg deletePartsType(String id){
        int i = partsTypeService.deletePartsTypeById(id);
        if (i>0){
            return Msg.success().add("msg","删除配件类型成功");
        }else {
            return Msg.success().add("msg","删除配件类型失败");
        }
    }
    //修改配置类修
    @RequestMapping("updatePartsType")
    public Msg updatePartsType(@RequestParam(value = "id") String id,@RequestParam(value = "name") String name){
        PartsType one = partsTypeService.selectPartsTypeOneById(id);
        one.setName(name);
        int i = partsTypeService.updatePartsTypeById(one);
        if (i>0){
            return Msg.success().add("msg","修改配件类型成功");
        }else {
            return Msg.success().add("msg","修改配件类型失败");
        }
    }
    //查询配置类型
    @RequestMapping("selectPartsTypeByCondition")
    public Page selectPartsTypeByCondition(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "partsName", defaultValue = "") String name){
        Page<PartsType> partsTypePage = new Page<>(page,limit);
        QueryWrapper<PartsType> queryWrapper = new QueryWrapper<>();
        if (!name.isEmpty()){
            queryWrapper.eq("name",name);
        }

        Page info = partsTypeService.selectPartsTypeWithCondition(partsTypePage, queryWrapper);
        return info;
    }

    /***
     * 配件图片
     * 增删改查
     */
    //新增图片
//    @RequestMapping("savePartsImg")
//    public Msg savePartsImg(MultipartFile img){
//        return Msg.success().add("msg","图片新增成功");
//    }
    //删除图片
    @RequestMapping("deletePartsImg")
    public Msg deletePartsImg(String id){
        int i = partsImgService.deletePartImgById(id);
        if (i>0){
            return Msg.success().add("msg","图片删除成功");
        }else {
            return Msg.success().add("msg","图片删除失败");
        }
    }
    //查看图片
    @RequestMapping("selectPartsImgList")
    public List selectPartsImgList(String partsId){
        QueryWrapper<PartsImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parts_id",partsId);
        List<PartsImg> list = partsImgService.selectPartsImgListById(queryWrapper);
        return list;
    }

}
