package inc.sims.hustles.service;

import inc.sims.hustles.model.JobPost;
import inc.sims.hustles.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepository.findAll();
    }

    public JobPost getJob(int postId) {
        Optional<JobPost> jobPost = jobRepository.findById(postId);
        return jobPost.orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepository.deleteById(postId);
    }
}
