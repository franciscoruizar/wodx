package ar.franciscoruiz.shared.infrastructure.hibernate;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class HibernateConfigurationFactory extends Configuration {
    private final Logger               logger;
    private final EnvironmentParameter environmentParameter;
    private final String               contextName;

    public HibernateConfigurationFactory(Logger logger, EnvironmentParameter environmentParameter, String contextName) {
        this.logger               = logger;
        this.environmentParameter = environmentParameter;
        this.contextName          = contextName;

        initConfiguration();
    }

    private void initConfiguration() {
        try {
            List<Resource> mappingFiles = searchMappingFiles(contextName);

            this.setProperties(hibernateProperties());

            for (Resource resource : mappingFiles) {
                this.addFile(resource.getFile().getCanonicalFile());
            }

        } catch (IOException | ParameterNotExist e) {
            logger.critical(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public SessionFactory buildSessionFactory() throws HibernateException {
        return super.buildSessionFactory();
    }

    private List<Resource> searchMappingFiles(String contextName) {
        List<String> modules   = subdirectoriesFor(contextName);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor(String contextName) {
        String[] packages = getSourcePackageName();

        String path = "./src/" + contextName + "/main/" + packages[0] + "/" + packages[1] + "/" + contextName + "/";

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  = "./main/" + packages[0] + "/" + packages[1] + "/" + contextName + "/";
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private String[] getSourcePackageName() {
        String[] packages = this.getClass().getPackageName().split("\\.");
        return new String[]{packages[0], packages[1], packages[2]};
    }

    private Properties hibernateProperties() throws ParameterNotExist {
        final String contextNameUpperCase = contextName.toUpperCase(Locale.ROOT);
        final String HOST                 = environmentParameter.get(String.format("%s_DATABASE_HOST", contextNameUpperCase));
        final String PORT                 = environmentParameter.get(String.format("%s_DATABASE_PORT", contextNameUpperCase));
        final String DATABASE_NAME        = environmentParameter.get(String.format("%s_DATABASE_NAME", contextNameUpperCase));
        final String USER                 = environmentParameter.get(String.format("%s_DATABASE_USER", contextNameUpperCase));
        final String PASSWORD             = environmentParameter.get(String.format("%s_DATABASE_PASSWORD", contextNameUpperCase));

        final String URL = String.format(
            "jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            HOST,
            PORT,
            DATABASE_NAME
        );

        Properties hibernateProperties = new Properties();

        hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        hibernateProperties.put(Environment.URL, URL);
        hibernateProperties.put(Environment.USER, USER);
        hibernateProperties.put(Environment.PASS, PASSWORD);
        hibernateProperties.put(Environment.HBM2DDL_AUTO, "none");
        hibernateProperties.put(Environment.SHOW_SQL, "true");

        return hibernateProperties;
    }


}
