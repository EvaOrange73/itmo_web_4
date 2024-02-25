<template>
  <div>
    <button
        v-on:click="show_sign_in"
        :class="sign_in_class()"
    >
      Войти
    </button>
    <button
        v-on:click="show_sign_up"
        :class="sign_up_class()"
    >
      Зарегистрироваться
    </button>
  </div>
  <div v-if="sign_in">
    <SingIn
        :wrong_password="this.wrong_password"
        :successful_registration="this.successful_registration"
    />
  </div>
  <div v-else>
    <SingUp
        :username_taken="this.username_taken"
    />
  </div>
</template>

<script>

import SingUp from "@/components/forms/SignUpForm.vue";
import SingIn from "@/components/forms/SignInForm.vue";

export default {
  name: 'TwoForms',
  components: {SingIn, SingUp},
  props: [
    'default_form',
    'wrong_password',
    'username_taken',
    'successful_registration',
  ],
  data() {
    return {
      sign_in: this.default_form
    }
  },
  methods: {
    show_sign_in() {
      this.sign_in = true;
    },
    show_sign_up() {
      this.sign_in = false;
    },
    sign_in_class() {
      return this.sign_in ? "selected" : "";
    },
    sign_up_class() {
      return this.sign_in ? "" : "selected";
    }
  }
}
</script>

<style>
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