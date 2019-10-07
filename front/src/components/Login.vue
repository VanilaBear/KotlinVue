<template>
  <form method="post" action="index.html">
    <div class="box">
      <h1>Advertisements</h1>

      <input type="login" name="login" value="login" class="email" v-model="username"  placeholder="Login" />

      <input type="password" name="password" value="password" class="email" v-model="password" placeholder="Password"  />
      <p>{{localMessage}}</p>
      <a @click="signIn">
        <div class="btn">Sign In</div>
      </a>
      <!-- End Btn -->

      <a @click="singUp">
        <div id="btn2">Sign Up</div>
      </a>
      <!-- End Btn2 -->
    </div>
    <!-- End Box -->
  </form>
</template>

<script>
import store from "../store";
import router from "../router";
import requester from "../requester";
export default {
  data() {
    return {
      username: "",
      password: "",
      localMessage: ""
    };
  },
  methods: {
    signIn() {
      requester("login", "POST", {
        username: this.username,
        password: this.password
      }).then(async response => {
        if (response.ok) {
          let authorization = await response.headers.get("authorization");
          store.commit("setName", this.username);
          store.commit("setIsAdmin", this.username == "admin");
          store.commit("setauthorizationHeader", authorization);
          store.commit("setAuthorized", true);
          router.push("/");
        } else {
          let responseBody = await response.json();
          this.localMessage = responseBody.message;
        }
      });
    },
    singUp() {
      requester("sign-up", "POST", {
        username: this.username,
        password: this.password
      }).then(async response => {
        if (response.ok) {
          this.localMessage = "Вы успешно зарегестрировались!";
        } else {
          let responseBody = await response.json();
          this.localMessage = responseBody.message;
        }
      });
    }
  }
};
</script>

<style scoped>
p {
  font-size: 12px;
  text-decoration: none;
  color: #000000;
}

h1 {
  font-size: 1.5em;
  color: #525252;
}

.box {
  background: white;
  width: 300px;
  border-radius: 6px;
  margin: 0 auto 0 auto;
  padding: 0px 0px 70px 0px;
  border: #fff 4px solid;
}

.email {
  background: #ecf0f1;
  border: #ccc 1px solid;
  border-bottom: #ccc 2px solid;
  padding: 8px;
  width: 250px;
  color: #aaaaaa;
  margin-top: 10px;
  font-size: 1em;
  border-radius: 4px;
}

.password {
  border-radius: 4px;
  background: #ecf0f1;
  border: #ccc 1px solid;
  padding: 8px;
  width: 250px;
  font-size: 1em;
}

.btn {
  background: #2ecc71;
  width: 125px;
  padding-top: 5px;
  padding-bottom: 5px;
  color: white;
  border-radius: 4px;
  border: #27ae60 1px solid;

  margin-top: 20px;
  margin-bottom: 20px;
  float: left;
  margin-left: 16px;
  font-weight: 800;
  font-size: 0.8em;
}

.btn:hover {
  background: #2cc06b;
}

#btn2 {
  float: left;
  background: #3498db;
  width: 125px;
  padding-top: 5px;
  padding-bottom: 5px;
  color: white;
  border-radius: 4px;
  border: #2980b9 1px solid;

  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 10px;
  font-weight: 800;
  font-size: 0.8em;
}

#btn2:hover {
  background: #3594d2;
}
</style>