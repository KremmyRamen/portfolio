<script>
export default {
  data() {
    return {
      error: false,
      result: 0,
      num1: "",
      num2: "",
      operation: "",
      expression: "",
    };
  },
  methods: {
    C() {
    this.error = false;
    this.result = 0;
    this.num1 = "";
    this.num2 = "";
    this.operation = "";
    this.expression = "";
    },
    add() {
      this.operation = "+";
      this.expression += " + ";
      console.log(this.operation +" was clicked");
    },
    subtract() {
      this.operation = "-";
      this.expression += " - ";
      console.log(this.operation +" was clicked");
    },
    time() {
      this.operation = "*";
      this.expression += " * ";
      console.log(this.operation +" was clicked");
    },
    divide() {
      this.operation = "/";
      this.expression += " / ";
      console.log(this.operation) +" was clicked";
    },
    num(x) {
      if (this.operation == "") {
        this.num1 += x;
        this.expression += x;
        console.log(x +" was clicked");
      } else {
        this.num2 += x;
        this.expression += x;
        console.log(x +" was clicked");
      }
    },
    equal() {
      if (this.operation == "+") {
        this.result = parseInt(this.num1) + parseInt(this.num2);
        this.expression = this.result.toString();
      } else if (this.operation == "-") {
        this.result = parseInt(this.num1) - parseInt(this.num2);
        this.expression = this.result.toString();        
      } else if (this.operation == "*") {
        this.result = parseInt(this.num1) * parseInt(this.num2);
        this.expression = this.result.toString();
      } else {
        if (this.num2 == 0) {
          this.error = true;
        } else {
          this.result = parseInt(this.num1) / parseInt(this.num2);
          this.expression = this.result.toString();
        }
      }
    },
  },
};
</script>
<template>
  <div class = "container">
    <header class="header">
      <input v-model="expression" />
      <p v-if="error">Cannot divide by 0</p>
      <div>
        <button class="operation" v-on:click="add">+</button>
        <button class="operation" v-on:click="subtract">-</button>
        <button class="operation" v-on:click="divide">/</button>
        <button class="operation" v-on:click="time">*</button>
      </div>
      <div>
        <button class="row1" v-on:click="num(7)">7</button>
        <button class="row1" v-on:click="num(8)">8</button>
        <button class="row1" v-on:click="num(9)">9</button>
        <button class="equal" v-on:click="equal">=</button>      
      </div>
      <div>
        <button class="row2" v-on:click="num(4)">4</button>
        <button class="row2" v-on:click="num(5)">5</button>
        <button class="row2" v-on:click="num(6)">6</button>
        <div class="empty" ></div>
      </div>
      <div>
        <button class="row3" v-on:click="num(1)">1</button>
        <button class="row3" v-on:click="num(2)">2</button>
        <button class="row3" v-on:click="num(3)">3</button>
        <div class="empty" ></div>
      </div>
        <button class="row4" v-on:click="num(0)">0</button>
        <button class="row4" v-on:click="C">C</button>
        <div class="empty" ></div>
        <div class="empty" ></div>
    </header>
    <main></main>
  </div>
</template>
<style>
@import "./assets/base.css";
#app {
  margin: 0px;
  padding: 2rem;
  font-weight: normal;
}
.header {
  text-align: center;
  padding: 30px 40px;
  background-color: rgb(0, 0, 0);
}
input {
  margin: 0;
  width: 50%;
  padding: 5px;
  float: center;
  font-size: 16px;
  border: 2px solid black;
}
.operation {
  padding: 10px;
  width: 12%;
  margin: 2px;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  cursor: pointer;
  border-radius: 0;
  color: #282828;
  background-color: #9e9b9b;
}
.empty {
  opacity: 0px;
  background-color: transparent;
}
.row1 {
  padding: 10px;
  width: 12.75%;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  padding: 20px;
  margin: 2px;
  border: 3px solid black;
  border-radius: 0;
  color: #282828;
  background-color: #ffffff;
}
.row2 {
  padding: 10px;
  width: 14%;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  padding: 20px;
  margin: 2px;
  border: 3px solid black;
  border-radius: 0;
  color: #282828;
  background-color: #ffffff;
}
.row3 {
  padding: 10px;
  width: 14%;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  padding: 20px;
  margin: 2px;
  border: 3px solid black;
  border-radius: 0;
  color: #282828;
  background-color: #ffffff;
}
.row4 {
  padding: 10px;
  width: 21.2%;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  padding: 20px;
  margin: 2px;
  border: 3px solid black;
  border-radius: 0;
  color: #282828;
  background-color: #ffffff;
}
.equal {
  width: 10%;
  text-align: center;
  font-size: 16px;
  transition: 0.3s;
  padding: 20px;
  border: 3px solid black;
  border-radius: 0;
  color: #282828;
  background-color: #2d6bf1;
}
.container {
  flex-flow: row wrap;
  font-weight: bold;
}
</style>