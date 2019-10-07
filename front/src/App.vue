<template>
  <div id="app">
    <b-row><b-col><img alt="Vue logo" src="./assets/logo.png" /></b-col></b-row>
    <b-row><b-col><b-button variant="outline-primary" v-if="authorized" @click="LogOut">Log out</b-button></b-col></b-row>
    <b-row><b-col><router-view></router-view></b-col></b-row>
  </div>
</template>

<script>
import store from "./store";
import router from "./router.js";

export default {
  name: "app",
  router,
  data() {
    return {};
  },
  computed: {
    authorized() {
      return store.state.authorized;
    }
  },
  methods: {
    LogOut(){
      store.commit('setauthorizationHeader', '')
      store.commit('setAuthorized', false)
      store.commit('setName', '')
      store.commit('setMessages', [])
      store.commit('setIsAdmin', false)
      router.push('login')
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
