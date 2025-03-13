#include "ArabRzymException.hpp"

ArabRzymException::ArabRzymException(const std::string& msg) {
  msg_ = msg;
}

ArabRzymException::~ArabRzymException() noexcept {}

const char* ArabRzymException::what() const noexcept {
  return msg_.c_str();
}