<template>
  <div>
    <div v-bind:key="index" v-for="(item, index) in messages">
      <MessageView v-bind:messageData="item" />
    </div>
    <MessageAdder />
  </div>
</template>

<script>
import store from "../store";
import requester from "../requester";
import MessageView from "./MessageView";
import MessageAdder from "./MessageAdder";

export default {
  components: {
    MessageView,
    MessageAdder
  },
  created: function() {
    requester("ads").then(async response => {
      let messages = await response.json();
      messages = messages.filter(item=>{
        return store.state.isAdmin||item.aproved
      })
      store.commit("setMessages", messages);
    });
  },
  computed: {
    messages() {
      return store.state.messages;
    }
  }
};
</script>

<style scoped>
</style>