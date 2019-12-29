cd ../
mvn clean package
cp ./controller/target/controller-1.0.0.jar ./docker/
cd ./docker
docker build -t be-inf:1.0.0 .
