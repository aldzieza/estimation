docker build . -t company2
docker stop company2 || true
docker rm company2 || true
docker run -d -p 8080:8080 --name=company2 -e SPRING_PROFILES_ACTIVE=prod --network company2-network --restart unless-stopped company2