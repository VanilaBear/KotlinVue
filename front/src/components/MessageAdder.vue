<template>
  <div>
      <h3>Ввести сообщение</h3>
      <b-row>
        <b-col>
          <input v-model="message" type="text" id="myInput" placeholder="Ввод" />
          <b-button variant="success" @click="AddMessage" class="addBtn">Добавить</b-button></b-col>
      </b-row>
  </div>
</template>

<script>
function getData() {
  requester("ads").then(async response => {
    let messages = await response.json();
    messages = messages.filter(item => {
      return store.state.isAdmin || item.aproved;
    });
    store.commit("setMessages", messages);
  });
}
import store from "../store";
import requester from "../requester";
export default {
  data() {
    return {
      message: ""
    };
  },
  methods: {
    AddMessage() {
      store.commit("addMessage", this.message);
      requester("ads", "POST", {
        author: store.state.name,
        msg: this.message
      }).then(() => {
        this.message = "";
        getData();
      });
    }
  }
};
</script>

<style scoped>
div{
}
</style>