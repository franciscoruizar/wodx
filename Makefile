all: build

up:
	@docker-compose up -d

build:
	@./gradlew build --warning-mode all

run-tests:
	@./gradlew test --warning-mode all

run:
	@./gradlew :run

build-jar:
	@./gradlew :bootJar

# Start the app
start-accounts_backend:
	@./gradlew :run --args='accounts_backend server'

start-analytics_backend:
	@./gradlew :run --args='analytics_backend server domain-events:rabbitmq:consume'

start-retentions_backend:
	@./gradlew :run --args='retention_backend server domain-events:rabbitmq:consume'

start-workouts_backend:
	@./gradlew :run --args='accounts_backend server'
