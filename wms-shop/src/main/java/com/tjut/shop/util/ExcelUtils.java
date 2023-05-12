package com.tjut.shop.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.mq.MessageSender;
import com.tjut.shop.service.MdGoodsService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtils {

    /**
     * 读入表格数据保存到数据库中
     * @param file 前端传来的文件
     * @param clazz 数据的class
     * @param dao 保存数据的service
     * @param <T>  声明数据类型
     * @param <Dao> service的泛型
     * @throws IOException
     */
    public static <T,Dao extends IService<T>> void readExcel(MultipartFile file, Class<T> clazz,Dao dao) throws IOException {
        DataListener<T, Dao> listener = new DataListener<>(dao);

        List<MdGoods> goodsList = EasyExcel.read(file.getInputStream(),clazz,listener)
                .head(clazz)
                .sheet()
                .doReadSync();
    }

    public static <T> void readExcelByMq(MultipartFile file, Class<T> clazz, MessageSender sender,String exchange,String rk) throws IOException {
        MqDataListener<Object> listener = new MqDataListener<>(sender, exchange, rk);
        List<MdGoods> goodsList = EasyExcel.read(file.getInputStream(),clazz,listener)
                .head(clazz)
                .sheet()
                .doReadSync();
    }


    public static <T,E> void exportExcel(List<T> list,Class<E> clazz,String filename,HttpServletResponse response) throws IOException {
        setExcelResponseProp(response,filename);
        EasyExcel.write(response.getOutputStream())
                .head(clazz)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet(filename)
                .doWrite(list);
    }

    private static void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8 " + fileName + ".xlsx");
    }
}

