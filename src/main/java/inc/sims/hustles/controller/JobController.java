package inc.sims.hustles.controller;

import inc.sims.hustles.model.JobPost;
import inc.sims.hustles.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("job_posts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("job_post/{post_id}")
    public JobPost getJobPost(@PathVariable("post_id") int postId){
        return jobService.getJob(postId);
    }

    @PostMapping("job_post")
    public JobPost addJobPost(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("job_post")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("job_post/{post_id}")
    public void deleteJobPost(@PathVariable("post_id") int postId){
        jobService.deleteJob(postId);
    }

    @GetMapping("load")
    public List<JobPost> loadJobs() {
        jobService.saveMultipleJobs();
        return jobService.getAllJobs();
    }
}
