package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UsersData;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @Test
    public void testChangePassword() throws Exception {

        String password = "newPassword";
        String adminLogin = "administrator";
        String adminPassword = "root";
        app.registration().login(adminLogin, adminPassword);
        app.registration().manageUsers();

        Users users = app.db().users();
        UsersData user = users.iterator().next();


        app.james().doesUserExist(user.getUsername());
        app.user().initModificationById(user.getId());
        app.user().resetPassword();
        app.registration().logout();
        List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), password, 60000);
        String resetPasswordLink = findResetPasswordLink(mailMessages, user.getEmail());
        String newPassword = "NewPassword";
        app.user().changePassword(resetPasswordLink, newPassword);
        assertTrue(app.newSession().login(user.getUsername(), newPassword));

    }

    private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


}