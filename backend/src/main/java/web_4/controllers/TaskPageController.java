package web_4.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web_4.AreaChecker;
import web_4.Point;
import web_4.PointDTO;
import web_4.PointRepository;

import java.util.Date;

@RestController
public class TaskPageController {
    @Autowired
    PointRepository repository;

    @GetMapping("/task")
    public ModelAndView taskPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("task_page");
        return modelAndView;
    }

    @GetMapping("/task/points")
    public String getPoint() {
        return new Gson().toJson(repository.findAll());
    }

    @PostMapping("/task/points")
    public void savePoint(@RequestBody PointDTO pointDTO) {
        Point point = new Point();
        long start = new Date().getTime();
        point.setX(pointDTO.getX());
        point.setY(pointDTO.getY());
        point.setR(pointDTO.getR());
        point.setResult(areaChecker.check(pointDTO.getX(), pointDTO.getY(), point.getR()));
        point.setRequestTime(start);
        point.setProcessTime(new Date().getTime() - start);
        repository.save(point);
    }
}
