<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <HelloWorld :msg="info" />
    <input type="text" v-model="message" />
    <button @click="alertMessage">Alert</button>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import axios from 'axios';

export default {
  name: "app",
  components: {
    HelloWorld
  },
  data() {
    return {
      message: "Hello World!",
      info:null,
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/1/track-info")
      .then(response => {
        this.info = response});
  },
  methods: {
    alertMessage() {
      alert(this.message);
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
