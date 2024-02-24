<template>
  <svg>
    <rect fill="#3399ff" x="150" y="150" v-bind:width="half_r" v-bind:height="r"/>
    <polygon fill="#3399ff" v-bind:points="polygon_points"/>
    <path fill="#3399ff" v-bind:d="path_points"/>
  </svg>
</template>

<script>
export default {
  name: "Figure",
  props: ['radius'],
  data() {
    return {
      r: this.$props.radius * 30,
      half_r: this.$props.radius * 30 / 2,
      polygon_points: '',
      path_points: ''
    }
  },
  mounted() {
    this.polygon_points = (150 - this.half_r) + ', 150 150,150 150,' + (150 + this.half_r);
    this.path_points = 'M150,150 L' + (150 + this.r) + ',150 A' + this.r + ',' + this.r + ' 0 0,0 150,' + (150 - this.r) + ' Z';
  }
}
</script>
