FROM nginx:alpine

#Copying files from my current folder location to docker file system 
# Will execute docker image when I am in that path

COPY . /usr/share/nginx/html  

EXPOSE 80

CMD ["nginx", "-g", "daemon off;", "-c", "/etc/nginx/nginx.conf"]
