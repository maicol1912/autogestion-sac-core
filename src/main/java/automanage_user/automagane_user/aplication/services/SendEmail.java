package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.configuration.EncodeUrlVerification;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendEmail {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmail.class);
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private freemarker.template.Configuration configurationFreeMarker;

    @Autowired
    private EncodeUrlVerification encoder;

    public Boolean sendNewEmailUser(UsuarioGeneralDto usuarioGeneralDto) throws MessagingException, IOException, TemplateException {

        try {
            MimeMessage messageAdmin = emailSender.createMimeMessage();
            Map<String, Object> modelAdmin = new HashMap<>();
            modelAdmin.put("cedula", usuarioGeneralDto.getEpl_nroid());
            modelAdmin.put("nombre", usuarioGeneralDto.getEpl_nombreuno());
            modelAdmin.put("apellido", usuarioGeneralDto.getEpl_apellidouno());
            modelAdmin.put("empresa", usuarioGeneralDto.getEmp_empresa());
            modelAdmin.put("link", "http/127.0.0.1:8080/sumas/usuarios/check/"+ usuarioGeneralDto.getEpl_nroid()+"/"+encoder.codificarUrl(usuarioGeneralDto.getEpl_nroid()));
            System.out.println("----------------");
            System.out.println(modelAdmin.get("link"));
            System.out.println("----------------");
            MimeMessageHelper helperAdmin = new MimeMessageHelper(messageAdmin, MimeMessageHelper.MULTIPART_MODE_MIXED);

            Template template = configurationFreeMarker.getTemplate("plantillaCorreo.html");
            String htmlAdmin = FreeMarkerTemplateUtils.processTemplateIntoString(template, modelAdmin);

            helperAdmin.setTo("maicoldev05@gmail.com");
            helperAdmin.setSubject("validar Activacion Usuario: " + usuarioGeneralDto.getEpl_nombreuno() + " "+ usuarioGeneralDto.getEpl_apellidouno());
            helperAdmin.setText(htmlAdmin, true);
            emailSender.send(messageAdmin);
            LOGGER.info(String.format("se acaba de enviar un correo del usuario ->%S",modelAdmin.get("nombre")+" "+modelAdmin.get("apellido")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
