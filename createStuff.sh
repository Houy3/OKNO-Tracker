docker network create tracker_network
docker volume create --name tracker_postgres_volume
read -n1 -r -p "Press any key to continue..." key