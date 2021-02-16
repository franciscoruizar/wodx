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

start-sales_backend:
	@./gradlew :run --args='sales_backend server'

start-authentications_backend:
	@./gradlew :run --args='authentications_backend server'

start-workouts_backend:
	@./gradlew :run --args='workouts_backend server'
