# Use a lightweight web server image
FROM nginx:alpine

# Copy your HTML files to the appropriate location in the container
COPY . /usr/share/nginx/html

# Expose port 8080 for the web server
EXPOSE 80

# Set "homelogin.html" as the default starting page
CMD ["nginx", "-g", "daemon off;", "-c", "/etc/nginx/nginx.conf"]
