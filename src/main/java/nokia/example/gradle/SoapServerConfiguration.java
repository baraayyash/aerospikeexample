package nokia.example.gradle;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapServerConfiguration extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformSchemaLocations(true);
		return new ServletRegistrationBean(servlet, "/soap/*");
	}
	
	@Bean
	public XsdSchema userSchema() {
		return new SimpleXsdSchema(new ClassPathResource("servers.xsd"));
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setSchema(userSchema);
		defaultWsdl11Definition.setLocationUri("/soap");
		defaultWsdl11Definition.setPortTypeName("serverService");
		defaultWsdl11Definition.setTargetNamespace("http://example.nokia/gradle/wsdl");
		
		return defaultWsdl11Definition;
	}
	
}
