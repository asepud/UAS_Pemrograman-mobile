<?php
  require APPPATH . 'libraries/REST_Controller.php';

  class Profil extends REST_Controller
  {
      function __construct(){
          parent::__construct();
          $this->load->model('profil_m', 'profil');
        }

      public function index_get(){
          $id = $this->get('id');
        if($id===null){
          $data = $this->profil->getAll();
        }else{
            $data = $this->profil->getAll($id);
        }

        if($data){
          $this->response([
            "message" => "data profil",
            "status" => true,
            "data" => $data
          ],REST_Controller::HTTP_OK);
        }else {
          $this->response([
            "message" => "data profil not found",
            "status" => false,
            "data" => $data
          ],REST_Controller::HTTP_NOT_FOUND);
        }
      }

      public function index_post()
      {
        $data=[
          'id' => $this->post('id'),
          'npm' => $this->post('npm'),
          'nama' => $this->post('nama'),
          'kelas' => $this->post('kelas'),
          'jurusan' => $this->post('jurusan'),
          'email' => $this->post('email'),
          'telp' => $this->post('telp')
        ];

        if($this->profil->create($data)>0){
          $this->response([
            "message" => " data profil has been created",
            "status" => true,
            "data" => $data
          ], REST_Controller::HTTP_CREATED);
        }else{
          $this->response([
            "message" => " add data profil Failed",
            "status" => false,
            "data" => $data
          ], REST_Controller::HTTP_BAD_REQUEST);
        }
      }

      public function index_put()
    {
      $id = $this->put('id');
      $data=[
        'id' => $this->put('id'),
        'npm' => $this->put('npm'),
        'nama' => $this->put('nama'),
        'kelas' => $this->put('kelas'),
        'jurusan' => $this->put('jurusan'),
        'email' => $this->put('email'),
        'telp' => $this->put('telp')
      ];

      if ($this->profil->edit($data, $id) > 0){
          $this->response([
              "status" => true,
              "message" => "new profil has been updated",
              "data" => $data
          ],  REST_Controller::HTTP_OK);
      }else {
          $this->response ([ 
              "message" => "update data failed",
              "status" => false,
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
          if($this->profil->delete($id) > 0 ){
              $this->response ([
              "message" => "deleted",
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
