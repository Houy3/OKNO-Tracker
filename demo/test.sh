docker build -t tracker .


docker run --name tracker1 -p  1001:8080 -d tracker


read -n1 -r -p "Press any key to continue..." key