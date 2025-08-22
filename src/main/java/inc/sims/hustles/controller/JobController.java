package inc.sims.hustles.controller;

import inc.sims.hustles.model.JobPost;
import inc.sims.hustles.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("job_posts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
}
