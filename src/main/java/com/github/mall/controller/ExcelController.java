package com.github.mall.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.mall.dao.DepartmentMapper;
import com.github.mall.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: wy
 * @Date: 2020/6/14 16:17
 * @Description:
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    DepartmentMapper departmentMapper;
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        List<Department> all = departmentMapper.findAll();
        ExcelWriter writer= ExcelUtil.getWriter(true);
        writer.write(all,true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=test.xlsx");
        writer.flush(response.getOutputStream(), true);
        writer.close();
        IoUtil.close(response.getOutputStream());
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Department> departmentList = reader.readAll(Department.class);
        departmentMapper.insertBatch(departmentList);
       return "ok";
    }

}
