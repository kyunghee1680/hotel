# 클라우드 네이티브 Final Project

## 클라우드 네이티브 아키텍처(IaaS)
![아키텍처](https://github.com/user-attachments/assets/16c92016-bce8-4ad8-b589-283e92cdd41a)


## 클라우드 네이티브 모델링(Biz.)
### 숙소 예약 서비스
![이벤트 스토밍](https://github.com/user-attachments/assets/b8917c7b-91ba-46ff-9534-16f1d8bcfacd)


## 클라우드 네이티브 개발 MSA(Dev.)
### 분산트랜잭션 - Saga & 보상처리 - Compensation
- Hotel Reservation Cancel 로직
- Payment Cancel 로직 
### 단일 진입점 - Gateway
![게이트웨이](https://github.com/user-attachments/assets/7f60a710-0ff7-44e7-96f2-a4f9dae1ba71)
### 분산 데이터 프로젝션 - CQRS
![CQRS](https://github.com/user-attachments/assets/98aaddd0-b8b0-49cb-885f-401685334b71)
![CQRS2](https://github.com/user-attachments/assets/c7e7bb23-230f-4e34-b48d-5f4201f3dd7a)

## 클라우드 네이티브 운영(PaaS)
### 클라우드 배포 - Container 운영

```
cd gateway
mvn spring-boot:run
```

## Test by API
- hotel
```
 http :8088/hotels id="id" roomCount="roomCount" hotelName="hotelName" status="status" 
```
- reservation
```
 http :8088/hotelReservations id="id" reservationId="reservationId" userId="userId" status="status" roomCount="roomCount" startDate="startDate" endDate="endDate" price="price" hotelName="hotelName" address="address" roomNumber="roomNumber" 
```
- payment
```
 http :8088/payments id="id" reservationId="reservationId" status="status" price="price" hotelName="hotelName" payDt="payDt" 
```
- mypage
```
```
- notification
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

