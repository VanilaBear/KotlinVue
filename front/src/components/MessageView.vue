<template>
  <div class="border">
    <div class="author">{{messageData.author}}</div>
    <div class="message">{{messageData.msg}}</div>
    <div v-if="isAdmin">
      <b-button variant="success" v-if="!messageData.aproved" @click="approveMsg" class='btn'>Approve</b-button>
      <b-button variant="danger" @click="deleteMsg"  class='btn'>Delete</b-button>
    </div>
  </div>
</template>

<script>
function getData() {
    requester("ads").then(async response => {
      let messages = await response.json();
      messages = messages.filter(item=>{
        return store.state.isAdmin||item.aproved
      })
      store.commit("setMessages", messages);
    });
  }
import store from "../store";
import requester from "../requester";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  props: {
    messageData: Object
  },
  methods: {
    approveMsg() {
      this.messageData.aproved = true
      requester("ads/" + this.messageData.id, "PUT", 
      {
        author:this.messageData.author,
        msg:this.messageData.msg,
        aproved:true
      }).then(()=>getData());
    },
    deleteMsg() {
      requester("ads/" + this.messageData.id, "DELETE").then(()=>getData());
    }
  },
  computed: {
    isAdmin() {
      return store.state.isAdmin;
    }
  }
};
</script>

<style scoped>
.message{
  text-align: center;
}
.author{
  color: #6b6b6b;


}
.border {
  text-align: right;
  width: 75%;
  margin: auto;
  background: #ecf0f1;
  border: rgb(0, 0, 0) 1px solid;
  border-bottom: #ccc 2px solid;
  color: #000000;
  font-size: 1em;
  border-radius: 4px;
  padding-bottom: 10px;
}
</style>