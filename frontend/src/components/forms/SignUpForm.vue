<template>
  <div id="sign_up">
    <p v-if="username_taken">
      Это имя занято.
    </p>

    <input type="text"
           name="username"
           placeholder="Имя"
           v-model="name"
           :class="error_class(name_error)"
    >
    <input
        type="password"
        name="password"
        placeholder="Пароль"
        v-model="password"
        :class="error_class(password_error)"
    >
    <input type="password"
           name="password_2"
           placeholder="Повторите пароль"
           v-model="password2"
           :class="error_class(password2_error)"
    >
    <input type="submit"
           value="Зарегистироваться"
           v-on:click="sign_up"
    >
  </div>
</template>

<script>
export default {
  name: 'SingIn',
  props: [
    'username_taken'
  ],
  data() {
    return {
      name: '',
      password: '',
      password2: '',
      name_error: false,
      password_error: false,
      password2_error: false
    }
  },
  beforeMount() {
    if (this.username_taken) {
      this.name_error = true;
    }
  },
  methods: {
    error_class(error) {
      return error ? 'error' : '';
    },
    sign_up() {
      this.name_error = false;
      this.password_error = false;
      this.password2_error = false;
      let validation = true;
      if (!this.name) {
        validation = false;
        this.name_error = true;
      }
      if (!this.password) {
        validation = false;
        this.password_error = true;
      }
      if (!this.password2) {
        validation = false;
        this.password2_error = true;
      }
      if (this.password !== this.password2) {
        validation = false;
        this.password_error = true;
        this.password2_error = true;
      }
      if (validation) {
        this.$root.sign_up(this.name, this.password);
      }
    }
  }
}
</script>

<style>
@import "../../../styles/form.css";
</style>