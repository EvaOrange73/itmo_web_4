<template>
  <div id="sign_in">
    <input type="text" name="username" placeholder="Имя" v-model="name" :class="name_error">
    <input type="password" name="password" placeholder="Пароль" v-model="password" :class="password_error">
    <input type="submit" value="Войти" v-on:click="sign_in">
  </div>
</template>

<script>
export default {
  name: 'SingIn',
  data() {
    return {
      name: '',
      password: '',
      name_error: '',
      password_error: ''
    }
  },
  methods: {
    sign_in() {
      this.name_error = '';
      this.password_error = '';
      let validation = true;
      if (!this.name) {
        validation = false;
        this.name_error = 'error';
      }
      if (!this.password) {
        validation = false;
        this.password_error = 'error';
      }
      if (validation) {
        this.$root.sign_in(this.name, this.password);
      }
    }
  }
}
</script>

<style>
@import "../../styles/form.css";
</style>