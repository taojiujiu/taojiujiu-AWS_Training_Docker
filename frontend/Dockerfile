FROM node:10-slim AS builder
WORKDIR /app
COPY . /app
RUN npm run build

# WORKDIR /app
# RUN npm install -g serve

# COPY ./dist ./dist
# WORKDIR /app
FROM node:10-slim
COPY --from=builder /app/dist ./dist
RUN npm install -g serve
ENTRYPOINT ["serve","-s","dist"]

EXPOSE 5000
