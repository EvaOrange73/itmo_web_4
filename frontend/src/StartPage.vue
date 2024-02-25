<template>
  <div class="mid">
    <div class="container">
      <div>
        <button
            v-on:click="select_sign_in"
            :class="sign_in_selected"
        >
          Войти
        </button>
        <button
            v-on:click="select_sign_up"
            :class="sign_up_selected"
        >
          Зарегистрироваться
        </button>
      </div>
      <div v-if="sign_in_selected">
        <SingIn/>
      </div>
      <div v-else>
        <SingUp/>
      </div>
    </div>
  </div>
</template>

<script>
import SingIn from "@/components/SignInForm.vue";
import SingUp from "@/components/SignUpForm.vue";

export default {
  name: 'Login',
  components: {SingIn, SingUp},
  data() {
    return {
      sign_in_selected: 'selected',
      sign_up_selected: '',
    }
  },
  methods: {
    select_sign_in() {
      this.sign_in_selected = 'selected';
      this.sign_up_selected = '';
    },
    select_sign_up() {
      this.sign_in_selected = '';
      this.sign_up_selected = 'selected';
    },
    sign_in(username, password) {
      const data = new URLSearchParams();
      data.append('username', username);
      data.append('password', password);
      fetch('/sign-in', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: data
      }).then(response => {
            if (response.redirected) {
              window.location.replace(response.url);
            }
          }
      )
    },
    sign_up(username, password) {
      let json = JSON.stringify({
        username: username,
        password: password
      });
      fetch('/sign-up', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: json
      }).then(response => {
            if (response.redirected) {
              window.location.replace(response.url);
            }
          }
      );
    }
  }
}
</script>

<style scoped>
body {
  background-color: #5F87CF;
  min-width: 350px;
}

.mid {
  width: 350px;
  margin: 10px auto;
}

.container {
  background-color: white;
  border-radius: 5px;
  box-shadow: #1F3F77 5px 5px 5px;
  padding: 5px;
  margin: 10px;
  height: 100%;
}

button {
  width: 50%;
  height: 20px;

  display: block;
  float: left;
  margin: 10px auto;

  background-color: white;
  border: none;
}

button:hover {
  border-bottom: 3px solid #3399ff;
}

.selected {
  border-bottom: 3px solid #3399ff;
}
</style>