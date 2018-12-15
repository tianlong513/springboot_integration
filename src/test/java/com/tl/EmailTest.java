package com.tl;

import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tl
 * @description: 邮件测试
 * @author: tianlong
 * @create: 2018-12-15 14:04
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TlApplication.class)
public class EmailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer = null;//FreeMarker的技术类

    /**
     * 测试普通文字邮件发送
     *
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        //与application.yml中的mail.username配置要一直
        message.setFrom("quantianlong0420@163.com");
        //发送人
        message.setTo("927920568@qq.com");
        message.setSubject("主题：测试邮件");
        message.setText("邮件测试内容");

        //发送邮件
        mailSender.send(message);
    }

    /**
     * 发送有附件的邮件
     *
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("quantianlong0420@163.com");
        helper.setTo("927920568@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        /**
         * 发送两个附件一个图片一个视频
         * new File(文件地址)
         */
        //添加一个图片附件
        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Administrator\\Documents\\WeChat Files\\TL000420\\Image\\Image\\45314955b8abfa69355d837ba4c4cb6b.jpg"));
        //添加一个视频附件
        FileSystemResource file2 = new FileSystemResource(new File("C:\\Users\\Public\\Videos\\Sample Videos\\movie.mp4"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.mp4", file2);

        mailSender.send(mimeMessage);
    }


    /**
     * 发送嵌入静态资源邮件
     *
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("quantianlong0420@163.com");
        helper.setTo("927920568@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:45314955b8abfa69355d837ba4c4cb6b\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Administrator\\Documents\\WeChat Files\\TL000420\\Image\\Image\\45314955b8abfa69355d837ba4c4cb6b.jpg"));
        helper.addInline("45314955b8abfa69355d837ba4c4cb6b", file);

        mailSender.send(mimeMessage);
    }

    /**
     * 使用FreeMarker模板发送模板邮件
     *
     * @throws Exception
     */
    @Test
    public void sendTempTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("quantianlong0420@163.com");
        helper.setTo("927920568@qq.com");
        helper.setSubject("主题：模板邮件");

        /**
         * model：传值给页面
         */
        Map<String, Object> model = new HashMap<>();
        model.put("username", "张三");
        model.put("url", "http://18.216.178.28/");
        //获取模板名
        Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate("template.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, model);
        //true显示html页面，false显示html源码，默认false
        helper.setText(text);

        mailSender.send(mimeMessage);

    }
}