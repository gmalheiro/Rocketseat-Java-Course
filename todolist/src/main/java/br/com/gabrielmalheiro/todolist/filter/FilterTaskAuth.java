package br.com.gabrielmalheiro.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class FilterTaskAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Execute some action
        // Stop the request
        // Make the request pipeline continue

        System.out.println("In filter");
        chain.doFilter(request, response);

    }

}