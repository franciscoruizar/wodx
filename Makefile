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
start-wodx_backend:
	@./gradlew :run --args='wodx_backend server'
