<template>
  <div id="sign_in">
    <p v-if="successful_registration">
      Регистрация прошла успешно.
    </p>
    <p v-if="wrong_password">
      Неверное имя или пароль.
    </p>

    <input type="text"
           name="username"
           placeholder="Имя"
           v-model="name"
           :class="error_class(name_error)"
    >
    <input type="password"
           name="password"
           placeholder="Пароль"
           v-model="password"
           :class="error_class(password_error)"
    >
    <input type="submit"
           value="Войти"
           v-on:click="sign_in"
    >
  </div>
</template>

<script>
export default {
  name: 'SingIn',
  props: [
    'wrong_password',
    'successful_registration',
  ],
  data() {
    return {
      name: '',
      password: '',
      name_error: false,
      password_error: false
    }
  },
  beforeMount() {
    if (this.wrong_password) {
      this.password_error = true;
    }
  },
  methods: {
    error_class(error) {
      return error ? 'error' : '';
    },
    sign_in() {
      this.name_error = false;
      this.password_error = false;
      let validation = true;
      if (!this.name) {
        validation = false;
        this.name_error = true;
      }
      if (!this.password) {
        validation = false;
        this.password_error = true;
      }
      if (validation) {
        this.$root.sign_in(this.name, this.password);
      }
    }
  }
}
</script>

<style>
@import "../../../styles/form.css";
</style>