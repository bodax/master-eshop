package util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourceUtils {
    public interface WithResourceCallback<T> {
        T apply(InputStream stream) throws Exception;
    }

    public static <T> T withResource(String source, WithResourceCallback<T> callback) {
        ClassPathResource resource = new ClassPathResource(source);
        try (InputStream stream = resource.getInputStream()) {
            return callback.apply(stream);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't read file as resources " + resource, e);
        }
    }

    public static String resourceAsString(String resource) {
        return withResource(resource, res -> IOUtils.toString(res, StandardCharsets.UTF_8));
    }

}
