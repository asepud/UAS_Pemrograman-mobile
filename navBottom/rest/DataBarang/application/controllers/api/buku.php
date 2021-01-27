<?php
  
  require APPPATH . 'libraries/REST_Controller.php';
  class Buku extends REST_Controller{

    function __construct(){
      parent::__construct();
      $this->load->model('buku_m', 'buku');
    }

    public function index_get()
    {
      $id = $this->get('id');
      if($id===null){
        $data = $this->buku->getAll();
      }else{
          $data = $this->buku->getAll($id);
      }

      if($data){
        $this->response([
          "message" => "data buku",
          "status" => true,
          "data" => $data
        ],REST_Controller::HTTP_OK);
      }else {
        $this->response([
          "message" => "data buku not found",
          "status" => false,
          "data" => $data
        ],REST_Controller::HTTP_NOT_FOUND);
      }
    }

    public function index_post()
    {
      $data = [
        'judul' => $this->post('judul'),
        'penulis' => $this->post('penulis'),
        'jenis' => $this->post('jenis'),
        'tahun' => $this->post('tahun'),
        'image' => $this->post('image')
      ];

      if($this->buku->create($data) > 0){
        $this->response([
          "message" => " data buku has been created",
          "status" => true,
          "data" => $data
        ], REST_Controller::HTTP_OK);
      }else{
        $this->response([
          "message" => " add data Failed",
          "status" => false,
          "data" => $data
        ], REST_Controller::HTTP_BAD_REQUEST);
      }
    }

    public function index_put()
    {
      $id = $this->put('id');
      $data = [
        'judul' => $this->put('judul'),
        'penulis' => $this->put('penulis'),
        'jenis' => $this->put('jenis'),
        'tahun' => $this->put('tahun'),
        'image' => $this->put('image')
      ];

      if ($this->buku->edit($data, $id) > 0){
          $this->response([
              "status" => true,
              "message" => "new buku has been updated",
              "data" => $data
          ],  REST_Controller::HTTP_OK);
      }else {
          $this->response ([ 
              "message" => "update data failed",
              "status" => false,
              "data" => $data
          ], REST_Controller::HTTP_BAD_REQUEST);
      }
    }

    public function index_delete(){

      $id = $this->delete('id');

      if($id === null){
          $this->response([ 
              "message" => "Provide an id",
              "status" => false,
          ], REST_Controller::HTTP_BAD_REQUEST);
      }else{
          if($this->buku->delete($id) > 0 ){
              $this->response ([
              "id" => $id,
              "message" => "deleted success! ",
              "status" => true,
              
              ], REST_Controller::HTTP_OK);
      
          }else {
              $this->response([
                  "message" => "not found",
                  "status" => false,
              ], REST_Controller::HTTP_BAD_REQUEST);
          }
      }
      
  }
}