ALTER TABLE "user" ADD COLUMN "role" VARCHAR(50)check (role in ('STUDENT','TEACHER','ADMIN'));