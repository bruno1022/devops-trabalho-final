provider "heroku" {
  email   = "felipe4253@gmail.com"
  api_key = "3edb29c8-7ef2-4a05-a0e7-82dbb506f669"
}
resource "heroku_app" "trabalho-final-devops" {
  name   = "trabalho-final-devops"
  region = "us"
}