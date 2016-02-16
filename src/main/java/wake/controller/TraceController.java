package wake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import wake.repository.TraceRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trace")
public class TraceController {
    @Autowired
    private TraceRepository repository;

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public void request(HttpServletRequest request) {
        Map<String, Object> info = new HashMap<>();
        addRequestInfoToMap(info, request);
        repository.add(info);
    }

    @RequestMapping(value = "/**", method = {
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT
    })
    public void requestBody(@RequestBody Object body, HttpServletRequest request) {
        Map<String, Object> info = new HashMap<>();
        addRequestInfoToMap(info, request);
        info.put("body", body);
        repository.add(info);
    }

    private void addRequestInfoToMap(Map<String, Object> info, HttpServletRequest request) {
        info.put("method", request.getMethod());
        info.put("path", request.getRequestURI().substring("/trace".length()));
        info.put("remote", request.getRemoteAddr());
    }
}
