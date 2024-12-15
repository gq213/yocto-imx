
CXXFLAGS += -Wall -O2
CXXFLAGS += -I.

SRC_CPP = $(wildcard *.cpp)
OBJ_CPP = $(patsubst %.cpp, %.o, $(SRC_CPP))

LDFLAGS += -L.
LIBS = -ltestlib

TARGET = testapp

all:$(TARGET)

testapp:$(OBJ_CPP)
	$(CXX) -o $@ $^ $(LDFLAGS) $(LIBS)

%.o:%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

.PHONY:clean
clean:
	-rm -rf $(TARGET) $(OBJ_CPP)
