package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test

    public void testCommits() throws IOException {
        Github github = new RtGithub("fa770e28b930726a0d5a78d4ad30dfb64a6e6964");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("enechka94", "java_pft")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
