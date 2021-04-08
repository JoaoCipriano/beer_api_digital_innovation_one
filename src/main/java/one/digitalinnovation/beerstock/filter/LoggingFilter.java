package one.digitalinnovation.beerstock.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        long endTime;
        String invokingLog;
        String executedLog;

        String urlWithParameters = getURLWithParameters(request);

        invokingLog = formatInvokingLog(urlWithParameters);
        LOGGER.info(invokingLog);

        filterChain.doFilter(request, response);

        endTime = System.currentTimeMillis() - startTime;
        executedLog = formatExecutedLog(urlWithParameters, endTime);
        LOGGER.info(executedLog);
    }

    private String getURLWithParameters(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();

        url.append(request.getMethod());
        url.append(" ");
        url.append(request.getRequestURL().toString());
        if (!request.getParameterMap().isEmpty()) {
            url.append("?");
            url.append(getParameters(request));
        }
        return url.toString();
    }

    private String getParameters(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();

        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            if (params.length() > 0)
                params.append("&");

            params.append(entry.getKey());
            params.append("=");
            params.append(String.join("",entry.getValue()));
        }
        return params.toString();
    }

    private String formatInvokingLog(String urlWithParameters) {
        return "Invoking: " + urlWithParameters;
    }

    private String formatExecutedLog(String urlWithParameters, long time) {
        return "Executed(" + time + " ms): " + urlWithParameters;
    }
}