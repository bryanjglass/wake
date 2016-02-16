package wake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wake.model.Trace;
import wake.repository.TraceRepository;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    public TraceRepository traceRepository;

    @RequestMapping
    @ResponseBody
    public List<Trace> list() {
        return traceRepository.findAll();
    }

    @RequestMapping(value = "/dump")
    public String dump(Model model) {
        model.addAttribute("traces", traceRepository.findAll());

        return "dump";
    }

    @RequestMapping(value = "/stream")
    public String stream(Model model) {
        return "stream";
    }
}
