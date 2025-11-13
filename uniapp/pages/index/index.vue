<template>
  <view class="container">
    <view class="header">
      <text class="title">Unsplash Photos</text>
    </view>
    
    <view v-if="isLoading" class="state-container">
      <text class="state-text">Đang tải dữ liệu...</text>
      </view>
    
    <view v-else-if="error" class="state-container error">
      <text class="state-text error-title">Đã xảy ra lỗi:</text>
      <text class="state-text error-message">{{ error }}</text>
      <button class="retry-button" @click="fetchPhotos">Thử lại</button>
    </view>
    
    <scroll-view v-else-if="photos.length > 0" class="photo-list" scroll-y>
      <view v-for="photo in photos" :key="photo.id" class="photo-card">
        
        <image 
          :src="photo.urls.small" 
          class="photo-image" 
          mode="aspectFill" 
        />
        
        <text class="photo-description">{{ photo.description || 'Không có mô tả' }}</text>
      </view>
    </scroll-view>

    <view v-else class="state-container">
      <text class="state-text">Không tìm thấy bức ảnh nào.</text>
    </view>
    
  </view>
</template>
<script lang="ts" setup>
import { ref, onMounted } from 'vue';


interface PhotoUrls {
  small: string;
  regular: string;
}


interface Photo {
  id: string;
  description: string | null; 
  urls: PhotoUrls;

}


const API_URL = 'https://api.unsplash.com/photos';


const ACCESS_KEY = 'QJ8VJBqhvYoEBDJik4uKvUnjzdaKIG3DqhOSCAweCN4'; 


const photos = ref<Photo[]>([]);       
const isLoading = ref<boolean>(true);    
const error = ref<string | null>(null);   


async function fetchPhotos() {
  isLoading.value = true;
  error.value = null;


  try {
    const res = await uni.request({
      url: API_URL,
      method: 'GET',
      data: {
        page: 1,
        per_page: 10,       
        client_id: ACCESS_KEY
      }
    });

    if (res.statusCode === 200) {
      photos.value = res.data as Photo[];
    } else {
      const errorData = res.data as { errors: string[] };
      throw new Error(`Lỗi API: ${res.statusCode} - ${errorData.errors?.join(', ')}`);
    }
  } catch (e: any) {
    console.error('Không thể tải ảnh:', e);
    error.value = e.message || 'Không thể kết nối đến máy chủ.';
  } finally {
    isLoading.value = false;
  }
}

onMounted(() => {
  fetchPhotos();
});
</script>

<style lang="scss" scoped>
  $primary-color: #333;
  $secondary-color: #777;
  $background-color: #f4f4f4;
  $card-background: #ffffff;
  $border-radius: 8px;
  $error-color: #e74c3c;

  .container {
    display: flex;
    flex-direction: column;
    height: 100vh;
    background-color: $background-color;
  }

  .header {
    padding: 20px 15px;
    background-color: $card-background;
    border-bottom: 1px solid #eee;
  }

  .title {
    font-size: 24px;
    font-weight: bold;
    color: $primary-color;
  }

  .state-container {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 20px;
  }

  .state-text {
    font-size: 16px;
    color: $secondary-color;
  }
  
  .error-title {
    font-size: 18px;
    font-weight: bold;
    color: $error-color;
  }
  .error-message {
    color: $error-color;
    text-align: center;
    margin-top: 5px;
  }

  .retry-button {
    margin-top: 15px;
    font-size: 14px;
    color: $primary-color;
    background-color: #eee;
    padding: 5px 15px;
  }


  .photo-list {
    flex: 1;
    height: 100%; 
  }

  .photo-card {
    background-color: $card-background;
    margin: 15px;
    border-radius: $border-radius;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden; 
  }

  .photo-image {
    width: 100%;
    height: 200px;
    background-color: #eee; 
  }

  .photo-description {
    padding: 10px 15px;
    font-size: 14px;
    color: $primary-color;
    display: block;
  }
</style>