package ru.stqa.pft.rest;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase{

    @Test

    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        int checkedIssueId = 1700; //1710 - ignored
        if(isIssueOpen(checkedIssueId)) {
            System.out.println("Ignored because of issue " + checkedIssueId);}
        skipIfNotFixed(checkedIssueId);
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = create(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(oldIssues, newIssues);

    }

}
