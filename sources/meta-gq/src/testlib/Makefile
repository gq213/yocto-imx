
CXXFLAGS += -Wall -O2 -fPIC
CXXFLAGS += -I.

SRC_CPP = $(wildcard *.cpp)
OBJ_CPP = $(patsubst %.cpp, %.o, $(SRC_CPP))

LDFLAGS += -shared

TARGET = libtestlib.so

all:$(TARGET)

libtestlib.so:$(OBJ_CPP)
	$(CXX) -o $@ $^ $(LDFLAGS)

%.o:%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

.PHONY:clean
clean:
	-rm -rf $(TARGET) $(OBJ_CPP)
