<template>
  <svg>
    <polygon fill="#3399ff" :points="rect_points"/>
    <polygon fill="#3399ff" :points="polygon_points"/>
    <path fill="#3399ff" :d="path_points"/>
  </svg>
</template>

<script>
export default {
  name: "Figure",
  props: ['radius'],
  computed: {
    rect_points() {
      return '150, 150 ' +
          '150 ' + (150 + this.radius * 30) +
          ' ' + (150 + this.radius * 30 / 2) + ',' + (150 + this.radius * 30) +
          ' ' + (150 + this.radius * 30 / 2) + ', 150'
    },
    polygon_points() {
      return (150 - this.radius * 30 / 2) +
          ', 150 150,150 150,' +
          (150 + this.radius * 30 / 2);
    },
    path_points() {
      return 'M150,150 L' +
          (150 + this.radius * 30) + ',150 A' +
          this.radius * 30 + ',' + this.radius * 30 +
          ' 0 0,0 150,' + (150 - this.radius * 30) +
          ' Z';
    }
  }
}
</script>
